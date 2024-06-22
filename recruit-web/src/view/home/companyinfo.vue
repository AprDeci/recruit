<script setup>
import card from '../../components/home/zujian/card.vue';
</script>

<template>
<card style="padding: 10px 20px;">
    <div style="display: flex;gap: 30px; align-items: center;margin-bottom: 10px;">
        <span style="font-weight: 500;">
            职位类型
        </span>
        <routerLink class="routerlink" :to="`/company/info/`+id+`?type=类型1`">类型1</routerLink>
        <routerLink class="routerlink" :to="`/company/info/`+id+`?type=类型1`">类型1</routerLink>
        <routerLink class="routerlink" :to="`/company/info/`+id+`?type=类型1`">类型1</routerLink>
    </div>
    <div style="display: flex;gap: 30px; align-items: center;margin-bottom: 10px;">
        <el-select size="small" style="width: 100px;" placeholder="工作城市">
            <el-option label="城市" value="1"><span style="font-size: 12px;">郑州</span></el-option>
        </el-select>
        <el-select size="small" style="width: 100px;">

        </el-select>

    </div>
</card>
</template>

<style scoped>
.routerlink{
    text-decoration: none;
    color: #000;
    font-size: 14px;
    font-weight: 400;
    margin-right: 10px;
}
.el-select:deep(.el-select__wrapper):deep(.el-select__selection):deep(.el-select__selected-item ):deep(span){
    font-size: 12px;
}
.el-input .el-input__inner {

font-size: 12px;

font-weight: bolder;

padding: 0 4px;

}
</style>