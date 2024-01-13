import router from "@/router";
import store from "@/store";
import ACCESS_ENUM from "@/authorization/accessEnum";
import checkAccess from "@/authorization/checkAccess";

router.beforeEach(async (to, from, next) => {
  console.log("user login info", store.state.user.loginUser);

  const loginUser = store.state.user?.loginUser;
  if (!loginUser || !loginUser.userRole) {
    await store.dispatch("user/getLoginUser");
  }

  const needAccess = (to.meta?.access as string) ?? ACCESS_ENUM.NOT_LOGIN;
  if (needAccess !== ACCESS_ENUM.NOT_LOGIN) {
    if (!loginUser || !loginUser.userRole) {
      next(`/user/login?redirect=${to.fullPath}`);
      return;
    }
    if (!checkAccess(loginUser, needAccess)) {
      next("/noAuth");
      return;
    }
  }
  next();
});
