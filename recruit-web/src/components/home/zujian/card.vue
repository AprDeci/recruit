<script setup>

</script>

<template>
    <div class="card">
        <slot></slot>
    </div>
</template>

<style scoped>
.card{
    max-width: 1200px;
    background-color: white;
    border-radius: 10px;
    margin-top: 10px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
    padding: 10px;
    box-sizing: border-box;
}
</style>