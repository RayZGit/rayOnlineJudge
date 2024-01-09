import { StoreOptions } from "vuex";
import ACCESS_ENUM from "@/authorization/accessEnum";

export default {
  namespaced: true,
  state: () => ({
    loginUser: {
      userName: "Not Login",
      userRole: ACCESS_ENUM.NOT_LOGIN,
    },
  }),
  actions: {
    getLoginUser({ commit, state }, payload) {
      commit("updateUser", payload);
    },
  },
  mutations: {
    updateUser(state, payload) {
      state.loginUser = payload?.loginUser;
    },
  },
} as StoreOptions<any>;
