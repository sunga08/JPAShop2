package jpabook.jpashop2.api;

import jpabook.jpashop2.domain.Member;
import jpabook.jpashop2.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member){ /* @RequestBody: json으로 온 body 데이터를 Member에 매핑해서 넣어줌 */
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @Data
    static class CreateMemberResponse{
        private Long id;

        public CreateMemberResponse(Long id){
            this.id = id;
        }
    }
}
