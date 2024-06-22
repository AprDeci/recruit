
<script setup>
import headmenu from "@/components/home/header.vue"
import searchinput from "@/components/home/search.vue"
import jobsorts from "@/components/home/sort.vue"
import adcard from "@/components/home/adcard.vue"
import hotposition from "@/components/home/hotposition.vue"
import hotcompany from "@/components/home/hotcompany.vue"
import foot from "@/components/footer.vue"

// 实现el-header吸顶效果
import { onMounted, ref,onUnmounted } from 'vue'

const y = ref(0)
const scrollTop = ()=>{
  y.value = document.documentElement.scrollTop
}
onMounted(()=>{
    window.addEventListener('scroll', scrollTop)
    })
onUnmounted(() => { 
  window.removeEventListener('scroll', scrollTop) 
  })
</script>

<template>
    <div class="common-layout">
      <el-container>
        <el-header style="padding: 0;" :class="{'isFixed':y>300}">
            <headmenu ></headmenu>
        </el-header>
        <el-main>
            <el-row><div class="headpic">
              <img id="headpic" src="@/imgs/backimg.png">
            </div></el-row>
            <el-row>
                <searchinput></searchinput>
            </el-row>
            <div class="main inner">
            <div class="sortads">
            <div class="sort" style="margin-right: 10px;"><jobsorts/></div>
            <div class="ads"><adcard></adcard></div>
          </div>
          <div class="hotpostion-container">
            <div class="hotpostion-title" style="text-align: center;">热招职位</div>
            <hotposition></hotposition>
          </div>
          <div class="hotcompany-container">
            <div class="hotcompany-title" style="text-align: center;">热门企业</div>
            <hotcompany></hotcompany>
          </div>
        </div>
        </el-main>
      </el-container>
<foot></foot>
    </div>
  </template>
  

  <style scoped>
.el-main{
  background: rgb(179,136,232);
  background: linear-gradient(180deg, rgba(179,136,232,0.35) 10%, rgba(255,242,109,0.07475884244372988) 25%, rgba(255,242,109,0.07154340836012862) 100%);
}
.el-row {
  margin-bottom: 20px;
  margin-right: 0;
  margin-left: 0;
}
.el-row:last-child {
  margin-bottom: 0;
}
.el-col {
  border-radius: 4px;
}
.el-main, .el-container { 
    padding: 0; margin: 0; 
}
.isFixed
{
  position: fixed;
  top: 0;
  z-index: 999;
  width: 100%;
}
.main{
  max-width: 1300px;
}
.inner{
  margin: 0 auto;
}
.headpic {
  width: 100vw;
  height: 150px;
  background-color: var(--ppcolor-deep);
}
#headpic{
  width: 40%;
  height: 100%;
  position: relative;
  left: 10%;
}
.sortads{
    display: flex;
    flex-wrap: warp;
    width: auto;
    align-items: center;
    justify-content: center;
}
.hotpostion-title,
.hotcompany-title
{
  margin-top: 20px;
  margin-bottom: 20px;
  font-size: 2.5rem;
  font-weight: bold;

}
</style>