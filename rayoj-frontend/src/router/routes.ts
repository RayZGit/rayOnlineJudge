import { RouteRecordRaw } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import AdminView from "@/views/AdminView.vue";
import NoAuth from "@/views/NoAuthView.vue";
import NoAuthView from "@/views/NoAuthView.vue";
import ACCESS_ENUM from "@/authorization/accessEnum";
import UserLayout from "@/layouts/UserLayout.vue";
import UserLoginView from "@/views/user/UserLoginView.vue";
import UserRegisterView from "@/views/user/UserRegisterView.vue";

export const routes: Array<RouteRecordRaw> = [
  {
    path: "/user",
    name: "user",
    component: UserLayout,
    meta: {
      hideInMenu: true,
    },
    children: [
      {
        path: "/user/login",
        name: "user login",
        component: UserLoginView,
      },
      {
        path: "/user/register",
        name: "user register",
        component: UserRegisterView,
      },
    ],
  },
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/admin",
    name: "Admin Only",
    component: AdminView,
    meta: {
      access: ACCESS_ENUM.ADMIN,
    },
  },
  {
    path: "/noAuth",
    name: "No Auth",
    component: NoAuthView,
    meta: {
      hideInMenu: true,
    },
  },
  {
    path: "/Problems",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
];
