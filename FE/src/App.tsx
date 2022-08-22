import { useRoutes } from "react-router-dom";
import Home from "./components/Home";
import React from "react";
import Dashboard from "./pages/Dashboard";
import Storage from "./components/Storage";

const App: React.FC = () => {
  const router = useRoutes([
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
