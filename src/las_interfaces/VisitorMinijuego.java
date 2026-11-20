package las_interfaces;

import monstruos.HombreLobo;
import monstruos.Momia;
import monstruos.Vampiro;
import monstruos.Zombi;

public interface VisitorMinijuego {
	double visitar(Zombi zombi);
	double visitar(Vampiro vampiro);
	double visitar(Momia momia);
	double visitar(HombreLobo hombrelobo);
}
