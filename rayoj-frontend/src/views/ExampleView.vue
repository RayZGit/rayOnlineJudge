<template>
  <div id="exampleView">
    <MdEditor :value="mdValue" :handle-change="onMDChange" />
    <CodeEditor :value="codeValue" :handle-change="onCodeChange" />
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue";
import MdEditor from "@/components/MdEditor.vue";
import CodeEditor from "@/components/CodeEditor.vue"; // @ is an alias to /src

const codeValue = ref();
const mdValue = ref();
const onCodeChange = (v: string) => {
  codeValue.value = v;
};

const onMDChange = (v: string) => {
  mdValue.value = v;
};
</script>
