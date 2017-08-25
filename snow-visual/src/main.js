import Vue from 'vue'
//全局引入jquery
import $ from 'jquery'

//引入组件
import App from './App.vue'

//引入bootstrap
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap.js'


new Vue({
  el: '#app',
  render: h => h(App)
})
