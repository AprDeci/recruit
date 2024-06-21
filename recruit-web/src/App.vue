<script setup>
import '@/global.css'
import "@/color.css"
</script>

<template>
<RouterView :key="$route.fullPath"></RouterView>
</template>

