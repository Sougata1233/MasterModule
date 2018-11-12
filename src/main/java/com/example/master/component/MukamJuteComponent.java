package com.example.master.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.master.entity.MukamJute;
import com.example.master.repository.MukamJuteRepository;

@Component
public class MukamJuteComponent {
	
	@Autowired
	MukamJuteRepository mukamJuteRepository;
	
	@Transactional
	public MukamJute save(MukamJute mukamjute) {
		return mukamJuteRepository.save(mukamjute);
	}
	
	@Transactional
	public List<MukamJute> findByMukamId(long mukamid){
		return mukamJuteRepository.findByMukamId(mukamid);
	}
	
	@Transactional
	public MukamJute findByMukamIdAndItemJuteCode(long mukamid, String itemJuteCode){
		return mukamJuteRepository.findByMukamIdAndItemJuteCode(mukamid, itemJuteCode);
	}
	
	public long getNextVal() {
		return mukamJuteRepository.seqVal();
	}
	
	public void delete(long id) {
		mukamJuteRepository.delete(id);
	}

}
