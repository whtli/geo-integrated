import request from "@/utils/request";

export function testCors() {
  return request({
    url: "/management/test/hello",
    method: "get",
  });
}
