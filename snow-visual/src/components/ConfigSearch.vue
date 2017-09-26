<template>

<div class="table-responsive">
      <table class="table table-striped">
        <thead>
          <tr>
            <th>名称</th>
            <th>当前状态</th>
            <th>转数类型</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for='config in trans_configs'>
            <td>{{ config.transName }}</td>
            <td>{{ valid[config.isValid] }}</td>
            <td>{{ type[config.type] }}</td>
          </tr>
        </tbody>
      </table>
    </div>

</div> <!-- /container -->
</template>

<style>

</style>

<script>

export default {
  data() {
    return {
      trans_configs : {},
      valid : ['有效','无效'],
      type : ['全量','增量']
    }
  },
  mounted: function() {
    this.$http.post('http://localhost:8080/snow/config/findAll', {}, {
        headers: {
          'Content-Type': 'application/json;charset=utf-8'
        }
    }).then(function(response) {
      // 这里是处理正确的回调
        this.trans_configs = response.data.configs;
          console.log(this.trans_configs[0]);
        // this.trans_configs = response.data["configs"] 也可以

    }, function(response) {
        // 这里是处理错误的回调
        console.log(response)
    });
  }
}
</script>
