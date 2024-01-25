<template>
  <div id="userLayout">
    <a-layout style="min-height: 100vh">
      <a-layout-header class="header">
        <a-space>
          <img src="../assets/logo.svg" class="logo" />
          <div>RayOJ</div>
        </a-space>
      </a-layout-header>
      <a-layout-content class="content">
        <router-view />
      </a-layout-content>
      <a-layout-footer class="footer"> RayOJ by Ray Zhou</a-layout-footer>
    </a-layout>
  </div>
</template>

<style scoped>
#userLayout {
  text-align: center;
  label-align: "left";
}

#userLayout .logo {
  width: 64px;
  height: 64px;
}
#userLayout .header {
  margin-top: 16px;
  margin-bottom: 16px;
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
