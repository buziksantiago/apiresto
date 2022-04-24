package api.restobot.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.restobot.app.exception.ResourceNotFoundException;
import api.restobot.app.model.Pedido;
import api.restobot.app.repository.PedidoRepository;



@RestController
@RequestMapping("/api/v1")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("pedido")
	public List<Pedido> getAllPedido(){
		return this.pedidoRepository.findAll();
	}
	
	@GetMapping("/pedido/{id}")
	public ResponseEntity<Pedido> getPedidoById(@PathVariable(value = "id") Long pedidoId)
			throws ResourceNotFoundException {
		Pedido pedido = pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + pedidoId));
		return ResponseEntity.ok().body(pedido);
	}
	
	@PostMapping("/pedidos")
	public Pedido createPedido(@RequestBody Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@PutMapping("/pedido/{id}")
	public ResponseEntity<Pedido> updatePedido(@PathVariable(value = "id") Long pedidoId,
			@RequestBody Pedido pedidoDetails) throws ResourceNotFoundException {
		Pedido pedido = pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> new ResourceNotFoundException("Pedido not found for this id :: " + pedidoId));

		pedido.setNombreCliente(pedido.getNombreCliente());
		pedido.setDireccionCliente(pedido.getDireccionCliente());
		pedido.setFecha(pedido.getFecha());
		pedido.setEstadoPedido(pedido.getEstadoPedido());
		pedido.setMontoTotal(pedido.getMontoTotal());
		pedido.setTipoPago(pedido.getTipoPago());

		final Pedido updatedPedido = pedidoRepository.save(pedido);
		return ResponseEntity.ok(updatedPedido);
	}
	
	@DeleteMapping("/pedidos/{id}")
	public Map<String, Boolean> deletePedido(@PathVariable(value = "id") Long pedidoId)
			throws ResourceNotFoundException {
		Pedido pedido = pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> new ResourceNotFoundException("Pedido not found for this id :: " + pedidoId));

		pedidoRepository.delete(pedido);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
