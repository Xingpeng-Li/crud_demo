let baseUrl = "";
// console.log(process.env.NODE_ENV)
switch (process.env.NODE_ENV) {
  case 'development':
    baseUrl = "http://localhost:9000/"  //开发环境url
    break
  case 'production':
    baseUrl = "http://192.168.196.146:9000/"   //生产环境url
    break
}
export default baseUrl;
