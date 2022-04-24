package api.restobot.app.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "fecha")
	private Timestamp fecha;
	
	@Column(name = "nombrecliente")
	private String nombreCliente;
	
	@Column(name = "direccioncliente")
	private String direccionCliente;
	
	@Column(name = "tipopago")
	private String tipoPago;
	
	@Column(name = "montototal")
	private double montoTotal;
	
	@Column(name = "estadopedido")
	private String estadoPedido;



	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}


	public Pedido(Timestamp fecha, String nombreCliente, String direccionCliente, String tipoPago, double montoTotal,
			String estadoPedido) {
		super();
		this.fecha = fecha;
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.tipoPago = tipoPago;
		this.montoTotal = montoTotal;
		this.estadoPedido = estadoPedido;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Pedido() {
		super();
	}
	
	
}
