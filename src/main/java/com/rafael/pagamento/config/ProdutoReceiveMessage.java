package com.rafael.pagamento.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.rafael.pagamento.data.vo.ProdutoVO;
import com.rafael.pagamento.entity.Produto;
import com.rafael.pagamento.repository.ProdutoRepository;

@Component
public class ProdutoReceiveMessage {
	
	private final ProdutoRepository produtoRepository;

	
	@Autowired
	public ProdutoReceiveMessage(ProdutoRepository produtoRepository) {		
		this.produtoRepository = produtoRepository;
	}
	
	/**
	 * Método que ficará escutando a fila rabbitMQ
	 */
	@RabbitListener(queues = {"${crud.rabbitmq.queue}"})
	public void receive(@Payload ProdutoVO produtoVO) {
		produtoRepository.save(Produto.create(produtoVO));
		
	}
	
	

}
