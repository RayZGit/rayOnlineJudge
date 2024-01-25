<template>
  <div id="code-editor" ref="codeEditorRef" style="min-height: 400px" />
</template>

<script setup lang="ts">
import * as monaco from "monaco-editor";
import { onMounted, ref } from "vue";

const codeEditorRef = ref();
const codeEditor = ref();
const value = ref("Hello World");

onMounted(() => {
  if (!codeEditorRef.value) {
    return;
  }
  codeEditor.value = monaco.editor.create(codeEditorRef.value, {
    value: value.value,
    language: "java",
    automaticLayout: true,
    readOnly: false,
    theme: "vs-dark",
    colorDecorators: true,
    minimap: {
      enabled: true,
    },
  });
});
</script>

<style scoped></style>
