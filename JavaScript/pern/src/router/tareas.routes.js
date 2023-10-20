import Router from "express-promise-router";
import { listarTareas, listarTarea, crearTarea, actualizarTareas, eliminarTareas } from "../controllers/tareas.controller.js";

const router = Router();

router.get("/tareas", listarTareas);

router.get("/tareas/:id", listarTarea);

router.post("/tareas", crearTarea);

router.put("/tareas/:id", actualizarTareas);

router.delete("/tareas/:id", eliminarTareas);

export default router;
