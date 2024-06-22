<script setup>
import typeselectmenu from "@/components/company/typeslectmenu.vue"

const props=defineProps({
    id:String
})
</script>

<template>
<typeselectmenu :id="id"></typeselectmenu>
<router-view></router-view>
</template>

<style scoped>

</style>