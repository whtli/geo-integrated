import router from "./router";
// import store from "./store";
import NProgress from "nprogress"; // progress bar
import "nprogress/nprogress.css"; // progress bar style
import getPageTitle from "@/utils/get-page-title";
import {getToken, getUserInfo, removeToken, setToken} from "@/utils/auth";
import { isTokenNeedToBeRefreshed, refreshToken } from "@/api/login";
NProgress.configure({ showSpinner: false }); // NProgress Configuration

const whiteList = ["/login"]; // no redirect whitelist

// 全局前置守卫,当有路由进行跳转时就会进入这个守卫
// to: Route: 即将要进入的目标 路由对象
// from: Route: 当前导航正要离开的路由
// next: Function: 一定要调用该方法来 resolve 这个钩子。执行效果依赖 next 方法的调用参数。
router.beforeEach((to, from, next) => {
  console.log("to ========= ");
  console.log(to);
  // 开始加载进度条
  NProgress.start();
  // 设置页面标题
  document.title = getPageTitle(to.meta.title);
  // 判断用户是否登录，有token值就意味着已经登录了
  // const hasToken = store.state.token;
  // const hasToken = localStorage.getItem("token");
  const hasToken = getToken();
  // console.log("判断用户是否登录: " + hasToken);
  if (hasToken) {
    // 有token
    // 获取用户信息
    const hasUserInfo = getUserInfo();
    if (!hasUserInfo) {
      // 没有用户信息
      // localStorage.removeItem("token");
      removeToken();
      next({ path: "/login" });
      // 进度条结束
      NProgress.done();
    } else {
      // 有用户信息
      if (to.path === "/login") {
        // 如果路由要跳转到登录页，重定向到主页
        next({ path: "/" });
        // 进度条结束
        NProgress.done();
      } else {
        isTokenNeedToBeRefreshed(hasToken).then((res) => {
          const flag = res.data;
          if (flag) {
            console.log("token 需要刷新了");
            refreshToken().then((res) => {
              const token = res.data.token;
              console.log("新token === ", token);
              setToken(token);
            });
          }
        })
        next();
      }
    }
  } else {
    // 没有token
    if (whiteList.indexOf(to.path) !== -1) {
      // 在白名单中的路由可以直接访问
      next();
    } else {
      // 不在白名单中的路由重定向到登录界面
      next(`/login?redirect=${to.path}`);
      NProgress.done();
    }
  }
});

//全局后置钩子
router.afterEach(() => {
  // finish progress bar
  NProgress.done();
});
