import { FacebookLogin } from "./components/FacebookLogin";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import Container from "@mui/material/Container";
import CssBaseline from "@mui/material/CssBaseline";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import ErrorPage from "./components/ErrorPage";
import ClippedDrawer from "./components/Dashboard";
import { green } from "@mui/material/colors";
import Catalog from "./components/Dashboard/Ecommerce/Catalog";

const theme = createTheme({
  palette: {
    primary: {
      main: green[400]
    }
  }
});

const router = createBrowserRouter([
  {
    path: "/",
    element: <FacebookLogin />,
    errorElement: <ErrorPage />
  },
  {
    path: "/login",
    element: <FacebookLogin />
  },
  {
    path: "/dashboard",
    element: <ClippedDrawer />,
    children: [{
      path: "catalog",
      element: <Catalog />
    }]
  },
]);

const App = () => {
  return (
    <div className="App">
      <ThemeProvider theme={theme}>
        <Container component="main" >
          <CssBaseline />
          <RouterProvider router={router}/>
        </Container>
      </ThemeProvider>
    </div>
  );
};

export default App;
