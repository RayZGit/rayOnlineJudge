import accessEnum from "@/authorization/accessEnum";
import ACCESS_ENUM from "@/authorization/accessEnum";

const checkAccess = (loginUser: any, needAccess = ACCESS_ENUM.NOT_LOGIN) => {
  const loginUserAccess = loginUser?.userRole ?? ACCESS_ENUM.NOT_LOGIN;
  if (needAccess === ACCESS_ENUM.NOT_LOGIN) {
    return true;
  }
  if (needAccess === ACCESS_ENUM.USER) {
    return loginUserAccess !== accessEnum.NOT_LOGIN;
  }
  if (needAccess === ACCESS_ENUM.ADMIN) {
    return loginUserAccess === ACCESS_ENUM.ADMIN;
  }
  return true;
};

export default checkAccess;
