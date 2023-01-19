import { useEffect } from "react";
import { checkLoginStatus, login } from "../app/services/facebook.service";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import Link from "@mui/material/Link";
import Box from "@mui/material/Box";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import FacebookIcon from '@mui/icons-material/Facebook';
import Typography from "@mui/material/Typography";
import Grid from "@mui/material/Grid";
import { green } from '@mui/material/colors';
import { useNavigate } from "react-router-dom";

const Copyright = (props: any) => {
  return (
    <Typography
      variant="body2"
      color="text.secondary"
      align="center"
      {...props}
    >
      {"Copyright © "}
      <Link color="inherit" href="https://vaini.com.ar/">
        Vaini Store
      </Link>{" "}
      {new Date().getFullYear()}
      {"."}
    </Typography>
  );
};

export const FacebookLogin = (): JSX.Element => {

  const navigate = useNavigate();

  const handleClickLogin = async () => {
    const { status } = await login();
    if (status === "connected") navigate("/dashboard");
  };

  useEffect(() => {
    checkLoginStatus().then(({ status }) => {
      if (status === "connected") navigate("/dashboard");
    });
  }, []);

  return (
    <Grid
      container
      spacing={0}
      direction="column"
      alignItems="center"
      justifyContent="center"
      style={{ minHeight: "100vh" }}
    >
      <Box
        sx={{
          marginTop: 8,
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
        }}
      >
        <Avatar sx={{ m: 1, bgcolor: green[500] }}>
          <LockOutlinedIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Conéctate y vende fácil
        </Typography>
        <Box component="div" sx={{ mt: 1 }}>
          <Button
            onClick={handleClickLogin}
            fullWidth
            variant="contained"
            sx={{ mt: 3, mb: 2 }}
            endIcon={<FacebookIcon />}
          >
            Facebook
          </Button>
        </Box>
      </Box>
      <Copyright sx={{ mt: 8, mb: 4 }} />
    </Grid>
  );
};
