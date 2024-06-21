<template>
    <el-card style="width: 400px;">
        <div class="fenleicontainer" v-for="i in 5">职业分类</div>
        <template #footer>footcontent</template>
    </el-card>
</template>

<style scoped>
.el-card {
    border-radius: 12px;
}

.fenleicontainer {
    height: 50px;
    border-radius: 10px;
    background-color: #fff;
    margin-bottom: 10px;
}
</style>