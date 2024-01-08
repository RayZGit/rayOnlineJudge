import { StoreOptions } from "vuex";

export default {
  namespaced: true,
  state: () => ({
    loginUser: {
      userName: "Not Login",
      role: "noAuth",
    },
  }),
  actions: {
    getLoginUser({ commit, state }, payload) {
      console.log(payload);
      commit("updateUser", payload);
    },
  },
  mutations: {
    updateUser(state, payload) {
      state.loginUser = payload?.loginUser;
    },
  },
} as StoreOptions<any>;
