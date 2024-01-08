import { createStore } from "vuex";
import user from "@/store/user";

export default createStore({
  state: () => ({ add: [] }),
  getters: {},
  mutations: {},
  actions: {},
  modules: {
    user,
  },
});
