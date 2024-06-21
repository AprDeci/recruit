<template>
    <el-card class="adcardcontianer" style="width: 870px;height: 400px;" body-class='bodyClass'>
        <el-card  class="adcard" shadow="hover">
            <img style="height: 266.66px;"src="https://img.bosszhipin.com/beijin/activity/img/20240221/488f35070cc7d0b69dc062f990bbd71bccc41632c9c835a480c0fe17b37418f00945b742138a9e17.png.webp" alt="">
        </el-card>
        <el-card  class="adcard" shadow="hover">
            <img style="height: 266.66px;" src="https://img.bosszhipin.com/beijin/activity/img/20240222/488f35070cc7d0b64964b50b0e6addabfb3df6182506fd7a80c0fe17b37418f00945b742138a9e17.png.webp" alt="">
        </el-card>
        <el-card  class="adcard" shadow="hover">
            <img style="height: 133.33px;" src="https://img.bosszhipin.com/beijin/activity/img/20240222/488f35070cc7d0b6e7d068d9b8f96584408f60dcb37df3cd80c0fe17b37418f00945b742138a9e17.png.webp" alt="">
        </el-card>
        <el-card  class="adcard" shadow="hover">
            <img style="height: 133.33px;" src="https://img.bosszhipin.com/beijin/activity/img/20240228/488f35070cc7d0b6d0945cbd3f9c51073ac02fecc9479e3780c0fe17b37418f00945b742138a9e17.png.webp" alt="">
        </el-card>
    </el-card>
</template>

<style scoped>
.adcardcontianer{
    border-radius: 12px;
}
.adcardcontianer :deep .bodyClass {
  display: grid;
  grid-template-columns: 2fr 1fr;
  grid-template-rows:  266.66px 133.33px;
  padding: 0;
}
.el-card :deep .el-card__body {
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