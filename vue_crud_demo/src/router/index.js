import Vue from 'vue'
import Router from 'vue-router'
import Home from "../components/Home"
import Add from "../components/Add";

Vue.use(Router)

export default new Router({
  routes: [
    {path: "/", name:"Home", component: Home},
    {path: "/add", name: "Add", component: Add}
  ],
  mode: "history"
})
