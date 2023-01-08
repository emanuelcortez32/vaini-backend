import { useEffect, useState } from "react";
import { checkLoginStatus, getMeData, login } from "../app/services/facebook.service";

export const FacebookLogin = (): JSX.Element => {
  const [isLogged, setIsLogged] = useState<boolean>(false);

  const handleClickLogin = async () => {
    const { status } = await login();
    if (status === "connected") setIsLogged(true);
  };

  useEffect(() => {
    checkLoginStatus().then(({ status }) => {
      if (status === "connected") setIsLogged(true);
    });
  }, []);

  return (
    <>
      {isLogged ? (
        <div>
          <p>CONECTADOOOOOO!!</p>
          <button onClick={getMeData}>
            ME
          </button>
        </div>
      ) : (
        <button onClick={handleClickLogin}>LOGIN</button>
      )}
    </>
  );
};
