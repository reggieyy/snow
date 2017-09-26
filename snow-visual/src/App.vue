  <template>

    <div id="app" class="container">

    <nav class="navbar navbar-default navbar-fixed-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">SNOW</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><router-link to="/configSet">配置</router-link></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">扩展<span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">监控</a></li>
                    <li><a href="#">数据报表</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">集群管理</a></li>
                    <li><a href="#">API</a></li>
                  </ul>
                </li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">{{ msg }}<span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="#">个人信息</a></li>
                  <li role="separator" class="divider"></li>
                  <li><a href="#">注销</a></li>
                </ul>
              </li>
              </ul>
            </div><!--/.nav-collapse -->
          </div>
        </nav>

        <div class="jumbotron">
          <p>SNOW是一个简单的ETL工具，目前支持一对一的转数，算法上没有特殊加工，只是对数据插入进行了切割</p>
          <p>支持即插即用，前后端完全分离，面向SOA</p>
        </div>
        <router-view></router-view>

    </div>

</template>

<style>
body {
  margin-top:70px;
}

.jumbotron {
  padding:15px 15px 15px 15px !important;
}

.jumbotron p {
  font-size:16px !important;
}
</style>

<script>
//import Sidebar from './components/Sidebar.vue'
export default {
  data() {
    return {
      msg : 'Welcome  Reggie '
    }
  }
}
</script>
