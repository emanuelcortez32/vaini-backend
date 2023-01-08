/// <reference types="node" />
/// <reference types="react" />
/// <reference types="react-dom" />

///types
type FBInitProps = {
  appId: string;
  cookie: boolean;
  xfbml: boolean;
  version: string;
};

type FBAuthResponse = {
  status?: "connected" | "not_authorized" | "unknown";
  authResponse?: {
    accessToken?: string;
    expiresIn?: string;
    signedRequest?: string;
    userID?: string;
  };
};

type FBLoginOptions = {
  scope: string;
  return_scopes?: boolean;
  auth_type?: string;
  enable_profile_selector?: boolean;
  profile_selector_ids?: string;
};

interface Window {
  fbAsyncInit: Function;
}

declare namespace NodeJS {
  interface ProcessEnv {
    readonly NODE_ENV: "development" | "production" | "test";
    readonly PUBLIC_URL: string;
    readonly REACT_APP_FB_ID_APP: string;
    readonly REACT_APP_FB_VERSION: string;
    readonly REACT_APP_PATH_ENDPOINT: string;
  }
}

declare namespace FB {
  export const init: (props: FBInitProps) => any;
  export const getLoginStatus: (cb: (response: FBAuthResponse) => any) => any;
  export const login: (
    cb: (response: FBAuthResponse) => any,
    options?: FBLoginOptions
  ) => any;
  export const logout: (cb: (response: any) => any) => any;
  export const api: (url: string, cb: (response: any) => any) => any;
  export const AppEvents: {
    logPageView: Function;
  };
}

declare module "*.avif" {
  const src: string;
  export default src;
}

declare module "*.bmp" {
  const src: string;
  export default src;
}

declare module "*.gif" {
  const src: string;
  export default src;
}

declare module "*.jpg" {
  const src: string;
  export default src;
}

declare module "*.jpeg" {
  const src: string;
  export default src;
}

declare module "*.png" {
  const src: string;
  export default src;
}

declare module "*.webp" {
  const src: string;
  export default src;
}

declare module "*.svg" {
  import * as React from "react";

  export const ReactComponent: React.FunctionComponent<
    React.SVGProps<SVGSVGElement> & { title?: string }
  >;

  const src: string;
  export default src;
}

declare module "*.module.css" {
  const classes: { readonly [key: string]: string };
  export default classes;
}

declare module "*.module.scss" {
  const classes: { readonly [key: string]: string };
  export default classes;
}

declare module "*.module.sass" {
  const classes: { readonly [key: string]: string };
  export default classes;
}
