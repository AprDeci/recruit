<script setup>
import { onMounted, ref } from 'vue';
import { CompanyinfoService } from '../../../api/company';

onMounted(() => {
  CompanyinfoService().then(res => {
    info.value=res.data
  })
})
const info = ref({});
</script>

<template>
 <el-form>
  <el-form-item label="公司ID">
    {{ info.id }}
  </el-form-item>
  <el-form-item label="公司名称">
    <el-input v-model="info.name" disabled></el-input>
  </el-form-item>
  <el-form-item label="公司地址">
    <el-input v-model="info.location" disabled></el-input>
  </el-form-item>
  <el-form-item label="公司描述">
    <el-input v-model="info.description" disabled></el-input>
  </el-form-item>
 </el-form>
</template>

<style scoped>

</style>