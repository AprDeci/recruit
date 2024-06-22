<template>
    <el-card class="adcardcontianer" style="width: 870px;height: 400px;" body-class='bodyClass'>
        <el-card  class="adcard" shadow="hover">
            <img style="height: 266.66px;"src="@/imgs/ad1.webp" alt="">
        </el-card>
        <el-card  class="adcard" shadow="hover">
            <img style="height: 266.66px;" src="@/imgs/ad2.webp" alt="">
        </el-card>
        <el-card  class="adcard" shadow="hover">
            <img style="height: 133.33px;" src="@/imgs/ad3.webp" alt="">
        </el-card>
        <el-card  class="adcard" shadow="hover">
            <img style="height: 133.33px;" src="@/imgs/ad4.webp" alt="">
        </el-card>
    </el-card>
</template>

<style scoped>
.adcardcontianer{
    border-radius: 12px;
}
.adcardcontianer :deep( .bodyClass ){
  display: grid;
  grid-template-columns: 2fr 1fr;
  grid-template-rows:  266.66px 133.33px;
  padding: 0;
}
.el-card :deep(.el-card__body) {
  padding: 0;
cursor: pointer;
}
.adcard{
  padding: 0;
  margin: 0;
}

.adcard:deep(.el-card__body) {
  filter: brightness(1);
}
.adcard:deep(.el-card__body):hover {
  filter: brightness(0.8);
  transition: all 0.5s ease-in-out;
}
 img{
width: 100%;
height: 100%;
object-fit: cover;
}
</style>