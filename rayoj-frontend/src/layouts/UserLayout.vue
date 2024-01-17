<template>
  <div id="userLayout">
    <a-layout style="min-height: 100vh">
      <a-layout-header class="header"> User Layout </a-layout-header>
      <a-layout-content class="content">
        <router-view />
      </a-layout-content>
      <a-layout-footer class="footer"> RayOJ by Ray Zhou</a-layout-footer>
    </a-layout>
  </div>
</template>

<style scoped>
#userLayout {
}

#userLayout .header {
  margin-bottom: 16px;
  box-shadow: #eee 2px 2px 5px;
}

#userLayout .content {
  background: linear-gradient(to right, #eee, #000);
  margin-bottom: 16px;
  padding: 20px;
}

#userLayout .footer {
  background: #efefef;
  padding: 16px;
  position: sticky;
}
</style>

<script></script>
