import { StoreOptions } from "vuex";
import ACCESS_ENUM from "@/authorization/accessEnum";
import { UserControllerService } from "../../generated";

export default {
  namespaced: true,
  state: () => ({
    loginUser: {
      userName: "Not Login",
      // userRole: ACCESS_ENUM.NOT_LOGIN,
    },
  }),
  actions: {
    async getLoginUser({ commit, state }, payload) {
      const res = await UserControllerService.getLoginUserUsingGet();
      // console.log("user/getLoginUser log, " + JSON.stringify(res));
      if (res.code === 0) {
        commit("updateUser", res.data);
      } else {
        commit("updateUser", {
          ...state.loginUser,
          userRole: ACCESS_ENUM.NOT_LOGIN,
        });
      }
    },
  },
  mutations: {
    updateUser(state, payload) {
      // console.log("user/updateUser log, " + JSON.stringify(payload));
      state.loginUser = payload;
    },
  },
} as StoreOptions<any>;
