import axios from "axios";
import { configAxios } from "../axios";

export const login = (): Promise<FBAuthResponse> => {
  const scope = [
    "pages_show_list",
    "pages_manage_metadata",
    "pages_messaging",
    "pages_read_engagement",
    "instagram_basic",
    "instagram_manage_messages",
  ].toString();
  return new Promise((resolve) => {
    FB.login(
      (response) => {
        configAxios(response.authResponse?.accessToken!);
        resolve(response);
      },
      { scope: scope, return_scopes: true }
    );
  });
};

export const checkLoginStatus = (): Promise<FBAuthResponse> => {
  return new Promise((resolve) => {
    FB.getLoginStatus((response) => {
      resolve(response);
    });
  });
};

export const getMeData = async () => {
  try {
    const data = (await axios.get('/facebook/auth')).data;
    console.log(data);
  } catch(err) {
    console.error(err);
  }
} 
