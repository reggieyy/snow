import Vue from 'vue'
//全局引入jquery
import $ from 'jquery'


//引入组件
import App from './App.vue'

//交互插件vue-resource
import VueResource from 'vue-resource'
//路由插件vue-router
import VueRouter from 'vue-router'


//引入bootstrap
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap.js'

//页面组件引入
import ConfigSet from './components/ConfigSet.vue'
import NotFound from './components/404.vue'
import ConfigSearch from './components/ConfigSearch.vue'

Vue.use(VueResource);
Vue.use(VueRouter);

const routes = [{
  path : '/',
  component : ConfigSearch
},{
  path : '/configSet',
  component : ConfigSet
},{
  path : '*',
  component : NotFound
}];

const router = new VueRouter({
  routes
});

new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
