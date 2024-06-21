<template>
    <div>
    <el-input
    class="selectinput"
    v-model="input"
    style="width: 700px;"
    size="large"
    placeholder="输入想要的工作"
    clearable
    />
    <el-button style="padding: 25px 40px; position: relative; bottom: 4px; right: 10px;" color="#626aef" size="large">search</el-button>
</div>
<div class="tags">
    <el-tag type="primary" @click="handleClick" >Tag 1</el-tag>
    <el-tag type="success">Tag 2</el-tag>
    <el-tag type="info">Tag 3</el-tag>
    <el-tag type="warning">Tag 4</el-tag>
    <el-tag type="danger">Tag 5</el-tag>
  </div>
</template>

<style scoped>
    div{
        width: 100vw;
        display: flex;
        justify-content: center;
        align-items: center;
        margin-bottom: 10px;
    }
    .selectinput:deep .el-input__wrapper{
        height: 48px;
    }
    div.tags{
        position: relative;
        display: flex;
        right: 100px;
        /* 调整每个元素之间的间距 */
        gap: 10px;

    }
</style>