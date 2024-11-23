//package umc.spring.practice.controller;
//
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import umc.spring.apiPayload.ApiResponse;
//import umc.spring.practice.Member;
//import umc.spring.practice.dto.MemberConverter;
//import umc.spring.practice.dto.MemberRequestDTO;
//import umc.spring.practice.dto.MemberResponseDTO;
//import umc.spring.practice.service.MemberCommandService;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/members")
//public class MemberRestController {
//
//    private final MemberCommandService memberCommandService;
//
//    @PostMapping("/")
//    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
//        Member member = memberCommandService.joinMember(request);
//        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
//    }
//}