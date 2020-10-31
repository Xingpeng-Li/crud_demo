// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
// import axios from 'axios'
// import qs from 'qs'
import 'bootstrap'
import * as filters from './util/filter'

//注册全局过滤器
Object.keys(filters).forEach(key => {
  Vue.filter(key, filters[key])
})

// Vue.config.productionTip = false
// axios.defaults.baseURL = 'http://localhost:9000'
// // axios.defaults.headers.post['Content-Type'] = "application/json"
// // axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*'
// // axios.defaults.withCredentials = true;
// // axios.defaults.headers.common['Authorization'] = store.state.token;
//
// Vue.prototype.axios = axios      //全局注册，使用方法为:this.axios
// Vue.prototype.qs = qs            //全局注册，使用方法为:this.qs

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
