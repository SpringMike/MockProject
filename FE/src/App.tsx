import { useRoutes } from "react-router-dom";
import Home from "./components/Home";
import Dashboard from "./pages/Dashboard";
import Storage from "./components/Storage";
import Login from "./components/Login";

const App: React.FC = () => {
  const router = useRoutes ([
    {
      path: "/login",
      element: <Login />
    },
    {
      path: "/",
      element: <Dashboard />,
      children: [
        {
          path: "",
          element: <Home />
        },
        {
          path: "/storage",
          element: <Storage />
        }
      ]
    }
  ])

  return router
};

export default App;
