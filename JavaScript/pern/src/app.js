import express from "express";
import morgan from "morgan";

const app = express();

app.use(morgan("dev"));

app.get("/", (req, res) => res.json({message: "Bienvenidos al proyecto"}));

export default app;
