<template>
  <a-row id="globalHeader" align="center" :wrap="false">
    <a-col flex="auto">
      <a-menu
        mode="horizontal"
        :selected-keys="selectedKey"
        @menu-item-click="doMenuClick"
      >
        <a-menu-item
          key="0"
          :style="{ padding: 0, marginRight: '38px' }"
          disabled
        >
          <div class="title-bar">
            <img class="logo" src="../assets/logo.svg" />
            <div class="title-bar-tittle">Ray - OJ</div>
          </div>
        </a-menu-item>
        <a-menu-item v-for="item in visibleRoutes" :key="item.path">
          {{ item.name }}
        </a-menu-item>
      </a-menu>
    </a-col>
    <a-col flex="100px">
      <div>{{ store.state?.user?.loginUser?.userName ?? "Not Login" }}</div>
    </a-col>
  </a-row>
</template>

<script setup lang="ts">
import { routes } from "@/router/routes";
import { useRouter } from "vue-router";
import { computed, ref } from "vue";
import { useStore } from "vuex";
import checkAccess from "@/authorization/checkAccess";
import ACCESS_ENUM from "@/authorization/accessEnum";

const router = useRouter();
const store = useStore();

const visibleRoutes = computed(() => {
  const loginUser = store.state.user.loginUser;
  return routes.filter((item) => {
    if (item.meta?.hideInMenu) {
      return false;
    }
    if (checkAccess(loginUser, item?.meta?.access as string)) {
      return true;
    }
    return false;
  });
});

// default home page
const selectedKey = ref(["/"]);

router.afterEach((to, from, failure) => {
  selectedKey.value = [to.path];
});

// setTimeout(() => {
//   store.dispatch("user/getLoginUser", {
//     loginUser: {
//       userName: "ray0",
//       userRole: ACCESS_ENUM.ADMIN,
//     },
//   });
// }, 3000);
const doMenuClick = (key: string) => {
  router.push({
    path: key,
  });
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.title-bar {
  display: flex;
  align-items: center;
}
.logo {
  height: 48px;
}
.title-bar-tittle {
  color: #444;
  margin-left: 16px;
}
</style>
