<template>
  <div class="about">
    <h1>This is an about page</h1>
    <img alt="Vue logo" src="../../assets/logo.png" />
    <HelloWorld msg="Welcome to Your Vue.js App" />
  </div>
</template>
<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";

export default {
  name: "Introduction",
  components: {
    HelloWorld,
  },
};
</script>
