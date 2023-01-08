import { configAxios } from "../axios";

export const initFacebookSdk = (
  appId?: string,
  version?: string
): Promise<void> =>
  new Promise((resolve, reject) => {
    // wait for facebook sdk to initialize before starting the react app
    window.fbAsyncInit = () => {
      FB.init({
        appId: appId || process.env.REACT_APP_FB_ID_APP,
        cookie: true,
        xfbml: true,
        version: version || process.env.REACT_APP_FB_VERSION,
      });

      FB.getLoginStatus(({authResponse, status}) => {
        if(status === "connected") configAxios(authResponse?.accessToken!);
      })

      resolve();
    };

    // load facebook sdk script
    ((d, s, id) => {
      var js,
        fjs = d.getElementsByTagName(s)[0];
      if (d.getElementById(id)) {
        return;
      }
      js = d.createElement(s) as HTMLScriptElement;
      js.id = id;
      js.src = "https://connect.facebook.net/en_US/sdk.js";
      fjs.parentNode!.insertBefore(js, fjs);
    })(document, "script", "facebook-jssdk");
  });
