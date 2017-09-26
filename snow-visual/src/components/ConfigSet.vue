<template>



  <div>
    <div class="col-md-8" style="padding-left:0px !important;">
      <div class="form-group">
        <label>配置名称&详细信息</label>
        <input type="text" class="form-control" name="transConfigModel.transName" placeholder="配置的简称，用于查询等使用...">
      </div>
      <div class="form-group">
        <textarea class="form-control" name="transConfigModel.transDesc" placeholder="请详细描述配置信息..."></textarea>
      </div>

      <div>
        <p></p>

      </div>


    </div>

    <div class="col-md-4" style="padding-right:0px !important;">
      <div class="form-group">
        <label>来源数据源</label>
        <select class="form-control" name="transConfigModel.sourceConfigID">
          <option v-for="source in sources" v-bind:value="source.sourceID">
            {{ source.sourceName }}
          </option>
        </select>
      </div>
      <div class="form-group">
        <label>来源数据表</label>
        <input type="text" class="form-control" name="transConfigModel.sourceTable" placeholder="...">
      </div>
      <div class="form-group">
        <label>目标数据源</label>
        <select class="form-control" name="transConfigModel.targetConfigID">
          <option v-for="source in sources" v-bind:value="source.sourceID">
            {{ source.sourceName }}
          </option>
        </select>
      </div>
      <div class="form-group">
        <label>目标数据表</label>
        <input type="text" class="form-control" name="transConfigModel.targetTable" placeholder="...">
      </div>
    </div>


  </div>




</template>

<script>
export default {
  name: 'hello',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      sourceConfigModel : {
        isValid : '1'
      },
      sources : {}
    }
  },
  mounted : function(){
    this.$http.post('http://localhost:8080/snow/config/findSourceConfigs', this.sourceConfigModel, {
        headers: {
          'Content-Type': 'application/json;charset=utf-8'
        }
    }).then(function(response) {
      // 这里是处理正确的回调
        this.sources = response.data.datas;
          console.log(this.sources);

    }, function(response) {
        // 这里是处理错误的回调
        console.log(response)
    });
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
