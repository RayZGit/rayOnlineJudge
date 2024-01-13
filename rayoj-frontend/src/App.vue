<template>
  <div id="app">
    <BasicLayout />
  </div>
</template>

<style>
#app {
}
</style>

<script setup lang="ts">
import BasicLayout from "./layouts/BasicLayout.vue";
import { onMounted } from "vue";

/**
 *  Global Initialization Function
 */
const doInit = () => {
  console.log("init");
};

onMounted(() => {
  doInit();
});
</script>
