<template>
  <div id="userLogin">
    <a-form
      style="max-width: 480px; margin: 0 auto"
      :model="form"
      label-align="left"
      auto-label-width
      @submit="handleSubmit"
    >
      <a-form-item
        field="userAccount"
        tooltip="Please enter account"
        label="Account"
      >
        <a-input
          v-model="form.userAccount"
          placeholder="please enter account..."
        />
      </a-form-item>
      <a-form-item field="userPassword" label="Password">
        <a-input-password
          v-model="form.userPassword"
          placeholder="please enter your password..."
        />
      </a-form-item>
      <a-form-item>
        <a-button html-type="submit" type="primary">Submit</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<style>
.about {
}
</style>

<script setup lang="ts">
import { reactive } from "vue";
import { UserControllerService, UserLoginRequest } from "../../../generated";
import message from "@arco-design/web-vue/es/message";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

const form = reactive({
  userAccount: "",
  userPassword: "",
}) as UserLoginRequest;

const router = useRouter();
const store = useStore();

const handleSubmit = async () => {
  const res = await UserControllerService.userLoginUsingPost(form);
  if (res.code !== 0) {
    message.error("Login Failed: " + res.message);
  } else {
    message.success("Login Success: " + res.message);
    store.dispatch("user/getLoginUser");
    router.push({
      path: "/home",
      replace: true,
    });
  }
};
</script>
