<template>
  <div id="basicLayout">
    <a-layout style="height: 400px">
      <a-layout-header class="header"> <GlobalHeader /> </a-layout-header>
      <a-layout-content class="content">
        <router-view />
      </a-layout-content>
      <a-layout-footer class="footer"> RayOJ by Ray Zhou</a-layout-footer>
    </a-layout>
  </div>
</template>

<style scoped>
#basicLayout {
}

#basicLayout .header {
  margin-bottom: 16px;
  box-shadow: #eee 2px 2px 5px;
}

#basicLayout .content {
  background: linear-gradient(to right, #eee, #000);
  margin-bottom: 16px;
}

#basicLayout .footer {
  background: #efefef;
  padding: 16px;
}
</style>

<script>
import { defineComponent } from "vue";
import GlobalHeader from "@/components/GlobalHeader.vue";

export default defineComponent({
  components: { GlobalHeader },
});
</script>
