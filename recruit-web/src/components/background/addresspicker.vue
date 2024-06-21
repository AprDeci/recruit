<script setup>
import json from '@/assets/dist.json'

</script>

<template>
  <el-cascader  filterable :options="json" :props="{checkStrictly: true,value:'name',label:'name',children:'children'}" />
</template>

<style scoped>

</style>