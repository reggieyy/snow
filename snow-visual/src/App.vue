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
                <li class="active"><a href="#">配置</a></li>
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

      <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>#</th>
                  <th>名称</th>
                  <th>当前状态</th>
                  <th>转数类型</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1,001</td>
                  <td>Lorem</td>
                  <td>ipsum</td>
                  <td>dolor</td>
                  <td>sit</td>
                </tr>
                <tr>
                  <td>1,002</td>
                  <td>amet</td>
                  <td>consectetur</td>
                  <td>adipiscing</td>
                  <td>elit</td>
                </tr>
                <tr>
                  <td>1,003</td>
                  <td>Integer</td>
                  <td>nec</td>
                  <td>odio</td>
                  <td>Praesent</td>
                </tr>
              </tbody>
            </table>
          </div>

    </div> <!-- /container -->

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
